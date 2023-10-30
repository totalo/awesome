查看文件某个位置的为某个值，并输出
```shell
# 这个是查看第7列的值为499的行
tail -f duokan.log  | awk '$7 == 499 {print}'
```