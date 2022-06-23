#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <arpa/inet.h>
#include <ctype.h>
#include <sys/socket.h>

/*
 * Select函数实现的单线程NIO多路复用 (读取)
 */
int main() {
    printf("Start...\n");
    // 缓冲区
    char buf[512];
    // 监听fd
    int listenFd = 0;
    // 通信fd临时变量
    int clientFd = 0;
    // 遍历上限
    int maxFd = 0;
    // 声明读取位图和总位图
    fd_set readFds, totalFds;
    // 初始化位图, 所有位设为0, 参数是位图指针
    FD_ZERO(&readFds);
    FD_ZERO(&totalFds);
    // 记录select函数返回值临时变量
    int k = 0;

    // 构建监听socket
    listenFd = socket(AF_INET, SOCK_STREAM, 0);
    maxFd = listenFd;
    // 将监听fd放入位图, 将参数0放入参数1位图指针指向的位图中
    FD_SET(listenFd, &totalFds);

    struct sockaddr_in server_address, client_address;
    socklen_t client_address_length;
    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(6130);
    server_address.sin_addr.s_addr = htonl(INADDR_ANY);
    client_address_length = sizeof(client_address);
    bind(listenFd, (struct sockaddr *)&server_address, sizeof(server_address));
    listen(listenFd, 100);

    while (1) {
        readFds = totalFds;
        // 最后一个参数超时时间虽然设置成NULL变成阻塞了, 但是这个阻塞会在监听到任何时间之后解除, 实际上并不影响而且非常高效
        // 参数0: 需要扫描的文件描述符数量上限+1
        // 参数1: 需要监听读事件的文件描述符位图
        // 参数2: 需要监听写事件的文件描述符位图
        // 参数3: 需要监听错误事件的文件描述符位图
        // 参数4: 结构体, 超时时间NULL为阻塞
        k = select(maxFd + 1, &readFds, NULL, NULL, NULL);
        if (k > 0) {
            // 判断是否有新的客户端连接
            if (FD_ISSET(listenFd, &readFds) > 0) {
                clientFd = accept(listenFd, (struct sockaddr *)&client_address, &client_address_length);
                maxFd = clientFd;
                // 将新的通信fd放入全部的fd位图中, 将参数0放入参数1位图指针指向的位图中
                FD_SET(clientFd, &totalFds);
                if (k == 1) {
                    continue;
                }
            }
        }
        int fd;
        for (fd = listenFd + 1; fd <= maxFd; fd++) {
            // 判断参数0是否在参数1指向的位图中存在
            if (FD_ISSET(fd, &readFds)) {
                int s = read(clientFd, buf, sizeof(buf));
                // 如果对端关闭了
                if (s == 0) {
                    // 将当前的通讯fd从需要监听的位图中清除, 将参数0从参数1位图指针指向的位图中移除
                    FD_CLR(fd, &totalFds);
                }
                write(STDOUT_FILENO, buf, s);
            }
        }
    }
    return 0;
}