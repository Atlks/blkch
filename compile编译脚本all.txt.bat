# 必须要apache-maven-3.6.3左右的。。。3.8的manven会报错。。。

set path=%path%;apache-maven-3.6.3/bin;
cd common-parent
rem xxx
 call mvn install
cd ../
cd  im-common
 call mvn install

cd  ../im-component
call mvn.cmd install


rem  编译api
cd  ../mianshi-im-api
call mvn.cmd install