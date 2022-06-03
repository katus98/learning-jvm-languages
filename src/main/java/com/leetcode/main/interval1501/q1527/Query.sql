select patient_id, patient_name, conditions
from Patients
where conditions regexp '.*\\sDIAB1|^DIAB1';