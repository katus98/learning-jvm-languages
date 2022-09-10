package com.leetcode.main.interval1701.q1797;

import java.util.Objects;
import java.util.TreeSet;

/**
 * 设计一个验证系统
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-10
 */
public class AuthenticationManager {
    private final TreeSet<Token> set;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.set = new TreeSet<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        set.add(new Token(tokenId, currentTime));
    }

    public void renew(String tokenId, int currentTime) {
        Token ojt = null;
        for (Token token : set) {
            if (token.key.equals(tokenId)) {
                if (token.time + timeToLive > currentTime) {
                    ojt = token;
                }
                break;
            }
        }
        if (ojt != null) {
            set.remove(ojt);
            ojt.time = currentTime;
            set.add(ojt);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int i = 0;
        for (Token token : set) {
            if (token.time + timeToLive > currentTime) {
                break;
            }
            i++;
        }
        return set.size() - i;
    }

    public static class Token implements Comparable<Token> {
        String key;
        int time;

        public Token(String key, int time) {
            this.key = key;
            this.time = time;
        }

        @Override
        public int compareTo(Token o) {
            int c = Integer.compare(this.time, o.time);
            return c == 0 ? this.key.compareTo(o.key) : c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Token token = (Token) o;
            return time == token.time && Objects.equals(key, token.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, time);
        }
    }
}
