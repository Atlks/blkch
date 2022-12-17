Markdown 基本语法
Markdown是一种轻量级标记语言，排版语法简洁，让人们更多地关注内容本身而非排版。它使用易读易写的纯文本格式编写文档，可与HTML混编，可导出 HTML、PDF 以及本身的 .md 格式的文件。因简洁、高效、易读

<!-- TOC -->

- [Markdown 标题语法  井号 (#)](#markdown-标题语法--井号-)
- [Markdown 强调语法](#markdown-强调语法)
- [Markdown 列表语法](#markdown-列表语法)
  - [Markdown 分隔线语法](#markdown-分隔线语法)
- [table of](#table-of)

<!-- /TOC -->


# Markdown 标题语法  井号 (#)
要创建标题，请在单词或短语前面添加井号 (#) 。# 的数量代表了标题的级别。例如，添加三个 # 表示创建一个三级标题 (<h3>) (例如：### My Header)。

Markdown语法	HTML	预览效果
  #Heading level 1	<h1>Heading level 1</h1>	
Heading level 1


# Markdown 强调语法
通过将文本设置为粗体或斜体来强调其重要性。

**aaa**  __bb__ bb

#粗体（Bold）
要加粗文本，请在单词或短语的前后各添加两个星号（asterisks）或下划线（underscores）。如需加粗一个单词或短语的中间部分用以表示强调的话，请在要加粗部分的两侧各添加两个星号（asterisks）。
Markdown语法	HTML	预览效果
I just love **bold text**.	I just love <strong>bold text</strong>.	I just love bold text.
I just love __bold text__.	I just love <strong>bold text</strong>.	I just love bold text.

 

# Markdown 列表语法
可以将多个条目组织成有序或无序列表。

#有序列表
要创建有序列表，请在每个列表项前添加数字并紧跟一个英文句点。数字不必按数学顺序排列，但是列表应当以数字 1 起始。

无序列表
要创建无序列表，请在每个列表项前面添加破折号 (-)、星号 (*) 或加号 (+) 。缩进一个或多个列表项可创建嵌套列表。

--------------------------------------------------------
## Markdown 分隔线语法
要创建分隔线，请在单独一行上使用三个或多个星号 (***)、破折号 (---) 或下划线 (___) ，并且不能包含其他内容。

# table of

Markdown 表格
要添加表，请使用三个或多个连字符（---）创建每列的标题，并使用管道（|）分隔每列。您可以选择在表的任一端添加管道。
msut need 多个连字.beir not show as tab

| Syntax      | Description |
| ----------- | ----------- |
| Header      | Title       |
| Paragraph   | Text        |

 


col1 | col2 | col3 | col4
| ----------- | ----------- |----------- |----------- |
col1 | col2 | col3 | col4

