
mmnc to addr eth

wallet-eth-android
cant inst



glare pave fatal catch cake large mad exit any hood expose neither
地址： 0x3a5c0fe05f7515a8283b1d2a1a241cbabafbf094
keystore： {"address":"3a5c0fe05f7515a8283b1d2a1a241cbabafbf094","id":"13b913ac-2d19-4473-8515-d6c54fe9bad8","version":3,"crypto":{"cipher":"aes-128-ctr","ciphertext":"66f392a77aff1f0c341519561c9eb5857ef44255b35d1781f2e3fd59a65e624f","cipherparams":{"iv":"dc81d0a5b103137c0b2f728a54ce6c17"},"kdf":"scrypt","kdfparams":{"dklen":32,"n":4096,"p":6,"r":8,"salt":"7dfa3c3de3cacfab8c93bd1790dce2476696222f10153913a7f0632b4026f914"},"mac":"2419dbdd294b4fe0bde158de2fefb218237b66316c0523911c18dad0828669f8"}}



涉及到的 BIP 协议：

BIP39 定义助记词的生成规则和助记词到种子的推导规则

BIP32 hd 钱包核心提案，定义分层概念和算法

BIP44 定义 5 层路径规则

BIP45 定义多签地址生成规则

BIP39
此处查看 BIP39 文档

文档概要：

定义了助记词的生成规则
定义了助记词到种子的转换规则
定义了助记词 wordlist，目前包含7种语言，每种 2048个单词
助记词到种子的推导是单向的
助记词的生成：

产生一个随机数作为熵 entropy，长度为 128-256 bits，必须为 32 bits 的整数倍。
然后在 entropy 尾部追加校验 checksum，checksum 是取 entropy 的 sha256 哈希值的前 n 位，位数跟 entropy 的长度有关，具体如下：


助记词到种子的推导：

通过 PBKDF2 函数生成大小为 64 byte 的种子。

PBKDF2（Password-Based Key Derivation Function 2）是一个基于口令的密钥推导方法，用于增强弱秘钥的安全性。本质上就是基于 hash 函数通过加盐和迭代因子让处理速度变慢，减少爆破风险。具体可参考 wiki

该函数定义如下：

DK = PBKDF2(PRF, Password, Salt, c, dkLen)

其中 ：

PRF 为伪随机函数相当于一个 hash 函数
Password 是口令，由用户负责安全
Salt 是盐，用于增加破解难度
c 是迭代次数，越大越安全
dkLen 是产生的密钥长度
在 bip39 中，用于产生种子的上述参数分别为：

HMAC-SHA512 单向的 hash 算法
助记词字符串
“mnemonic"+passphrase（口令是可选的）
2048
512（bits）
由函数 PBKDF2 可知，助记词到种子的推导是单向的不可逆的。



BIP44
查看文档：BIP44

概要：

定义了5层路径规则，可兼容多账号多币种
bip44 协议的 5 层路径规则：

路径：m/purpse’/coin_type’/account’/change/address_index（符号 ‘ 表示强化子秘钥，需要 index >= 2^{31}

m：主扩展密钥
purpose： bip44/bip45
coin_type： 币种
account： 钱包账户
change： 0 对外 / 1 找零
address_index： 地址索引


地址的最终生成
简单的理解，地址就是 公钥或者脚本 的哈希值的 base58 格式