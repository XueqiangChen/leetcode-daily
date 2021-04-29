# leetcode

## leetcode-edit 插件使用方法

在 JetBrain 公司的软件上安装 leetcode-edit 插件，插件安装完成后配置一下内容：

1. leetcode 的登录名和密码
2. 生成的模板配置
   `TempFilePath`: 模板生成后的位置，填写代码目录，例如: `D:\GitRepos\leetcode-questions\src\main\java`
   勾选 `CustomConfig` 启动自定义配置
   `CodeFileName`: 生成的文件名，`$!velocityTool.camelCaseName(${question.titleSlug})`
   `CodeTemplate`: 
   ```java
   // ${question.frontendQuestionId}-${question.title}

    ${question.content}
    
    package leetcode.editor.cn;
    public class $!velocityTool.camelCaseName(${question.titleSlug}){
        public static void main(String[] args) {
            Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        }
        ${question.code}
    }
   ```
