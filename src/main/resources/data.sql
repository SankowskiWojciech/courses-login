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






--INSERT INTO TOKEN(ID, TOKEN_VALUE, EMAIL_ADDRESS, RSA_PUBLIC_KEY, CREATION_DATE_TIME, EXPIRATION_DATE_TIME, IS_REVOKED) VALUES ('ff40d81e-63b3-4012-84fb-613d6246bab3', 'tokenValue', 'test1@gmail.com', 'rsaPublicKey', '2020-07-18T18:21:14.144', '2220-07-18T18:21:14.144', 'false');