-- ORGANIZATIONS
insert into ORGANIZATION(EMAIL_ADDRESS, ALIAS, NAME, DESCRIPTION)
values ('info@zslitnr1.pl', 'zslitnr1', 'Zespół szkół licealnych i technicznych nr 1 w Warszawie', 'Technikum mechatroniczno - informatyczne');
insert into ORGANIZATION(EMAIL_ADDRESS, ALIAS, NAME, DESCRIPTION)
values ('not.spam@dancewithme.pl', 'ssit', 'Szkoła śpiewu i tańca', 'Szkoła gdzie się uczy śpiewać i tańczyć');

-- TUTORS
insert into TUTOR(EMAIL_ADDRESS, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION)
values ('sankowski.wojciech@gmail.com', 'wsankowski', 'Wojciech', 'Sankowski', 'Java Developer');
insert into TUTOR(EMAIL_ADDRESS, ALIAS, FIRST_NAME, LAST_NAME, DESCRIPTION)
values ('kaminski.bart@dancewithme.pl', 'barkam', 'Bartosz', 'Kamiński', 'Profesjonalny tancerz');

-- PARENTS
insert into PARENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME)
values ('kbac@gmail.com', 'Kamil', 'Baczewski');

-- STUDENTS
insert into STUDENT(EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, PARENT_ID)
values ('marcin.b@gmail.com', 'Marcin', 'Baczewski', 'kbac@gmail.com');

-- SUBDOMAIN USER ACCESSES
insert into SUBDOMAIN_USER_ACCESS(SUBDOMAIN_EMAIL_ADDRESS, USER_EMAIL_ADDRESS)
values ('info@zslitnr1.pl', 'sankowski.wojciech@gmail.com');

-- LOGIN_CREDENTIALS
-- password: Test1
insert into LOGIN_CREDENTIALS(EMAIL_ADDRESS, ENCRYPTED_PASSWORD, ACCOUNT_TYPE) values ('sankowski.wojciech@gmail.com', 'JDJhJDE1JFhNV2RBYWxFREhQc3BKVk93cHRVdnVsN3QyRWMyLlVSZTNDMmJqR0MwNGkuNzdFTU9zVExD', 'TUTOR');

-- TOKENS
insert into TOKEN(TOKEN_ID, TOKEN_VALUE, USER_EMAIL_ADDRESS, ACCOUNT_TYPE, RSA_PUBLIC_KEY, CREATION_DATE_TIME, EXPIRATION_DATE_TIME) values ('ff40d81e-63b3-4012-84fb-613d6246bab3', 'eyJhbGciOiJFUzUxMiJ9.eyJqdGkiOiIxN2RjNmI3MC01ZWFiLTQxMzYtYmJlZS1mYTFjNjk1ZjAzMGIiLCJzdWIiOiJzYW5rb3dza2kud29qY2llY2hAZ21haWwuY29tIiwiaWF0IjoxNTk2NTM3NjU5LCJleHAiOjE1OTY1NDEyNTl9.ASq8hv-kiTnSiQnvrYJwhUztVyYV0_Rgk7TbvZiO-pooqmc9zDkODOT-8tabYl2XG1Ge8q2_OQfEUzq4_9FhQbFBAcZUheuJ5iP3koEz0-8R8e8rlCsI6Nyv_xx95EwIJJNJwEE7wGLQvPk8-hgBnu0MLEiEL9N9H_o6M8QQD6Qdu6zQ', 'sankowski.wojciech@gmail.com', 'TUTOR', 'MIGbMBAGByqGSM49AgEGBSuBBAAjA4GGAAQALwq2GPPSda8X5s6IcGvKTV8a+W/AtNBY1BI320wLFvoRg7tQC/iJhZ9aJo+sBzp2by4un4RehnRaBFg3nqqwOoIAJ0Oi4UaQYB+RpLAPLn9Wgkg+mlLlULwBWzqLb9qLEpA9OOq9ZbPQh/5narHYuuiD8/NDgIp9KuAN8o4MILqs9q0=', '2020-07-18T18:21:14.144', '2220-07-18T18:21:14.144');