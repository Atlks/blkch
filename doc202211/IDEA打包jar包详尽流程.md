IDEA打包jar包详尽流程

 
1. 打开菜单栏File-Project Structure
————————————————
2. 点击Artifacts
3. 3. 点击 "+" - JAR - From module with depenencies

Main Class选择自己要打包的类(
    com.shiku.imserver.IMServerStarter

 meta-inf/manifest.mf文件位置默认的
     D:\dev-server_java\shiku-im-server  即可



    ## zai ide上 5. 点击Build-Artifacts
    7. 此时Output directory便出现了jar包
    8. 一定要使用java - jar jar包名称