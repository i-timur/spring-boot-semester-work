<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="styles/contribution.css">
  <link rel="stylesheet" href="styles/header.css" type="text/css" />
  <title>${article.title}</title>
</head>
<body>
<div class="wrapper">
    <#include "_header.ftlh">
  <main class="main">
    <h2 class="main__title">
      ${article.title}
    </h2>
    <div class="main__text">
      ${article.text}
    </div>
  </main>
  <footer class="footer">
      <#if article??>
          Categories:
          <#if article.categories?has_content>
              <#list article.categories as category>
                ${category}
              </#list>
          </#if>
      </#if>
  </footer>
</div>
</body>
</html>