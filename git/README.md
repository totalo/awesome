### Git 常见场景使用总结

### 已经提交的文件，想再次添加到 gitignore 中

```bash
# 切换到你需要移出文件的分支，提 merge request 是不生效的，例如你想删除 master 上的，如果是切分支后提 mr 不剩，需要在 master 提交。

# 1. 先删除本地缓存
git rm -r --cached .

# 2. 编辑 .gitignore 文件，将需要移出的文件添加进去

# 3. 提交
git add .

# 4. 提交到远程仓库
git commit -m "update .gitignore"
git push
```
