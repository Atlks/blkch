

<!-- TOC -->

- [prgrmlan](#prgrmlan)
- [architecture  核心是biz层](#architecture--核心是biz层)
- [lib frm](#lib-frm)
- [db vs nosql](#db-vs-nosql)
- [code exmp](#code-exmp)
  - [util](#util)

<!-- /TOC -->

# prgrmlan

# architecture  核心是biz层
 mvc
 MVC模式最早由Trygve Reenskaug在1978年提出[1]，是全錄帕羅奧多研究中心（Xerox PARC）在20世紀80年代為程式語言Smalltalk發明的一種軟體架構。MVC模式的目的是實現一種動態的程式設計，使後續對程式的修改和擴充簡化，並且使程式某一部分的重複利用成為可能。除此之外，此模式透過對複雜度的簡化，使程式結構更加直覺。軟體系統透過對自身基本部分分離的同時也賦予了各個基本部分應有的功能。專業人員可以依據自身的專長分組

 jcu架构   json Controller   util


 也因為 MVC 模式強調職責分離，所以在發展 MVC 應用時會產生很多檔案，在 IDE (整合開發環境) 不夠成熟時它會是個問題，但在現代主流 IDE 都能使用類別物件的資訊來組織程式碼編輯的情況下，多檔案早已不是問題，


 我们常说的三层架构是由JavaWeb提出的，也就是说这是JavaWeb独有的！ 所谓三层是表现层（WEB层）、业务逻辑层（Business Logic），以及数据访问层（Data Access）。 开发中更多的是用到三层架构。很少提及MVC。


 db就是数据层。。。通过sql沟通。。 路由web曾是sprbt解决了。。。我们只需要编写业务逻辑层就可以了

 三層架構的優勢

從 開發角度和應用角度來看，三層架構比雙層或單層結構都有更大的優勢。三層結構適合群體開發，每人可以有不同的分工，協同工作使效率倍增。開發雙層或單層應 用時，每個開發人員都應對系統有較深的理解，能力要求很高，開發三層應用時，則可以結合多方面的人才，只需少數人對系統全面瞭解，從一定程度工降低了開發 的難度。
————————————————
 
 缺点不适合小项目和人少项目



 # lib frm

# db vs nosql


# code exmp

## util 