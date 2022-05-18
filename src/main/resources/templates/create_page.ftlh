<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="styles/header.css">
  <link rel="stylesheet" href="styles/create.css">
  <title>Create</title>
</head>
<body>
<div class="wrapper">
    <#include "_header.ftlh">
  <form id="form" action="/create" class="form" method="post">
    <div class="create">
      <h2 class="title">Название статьи</h2>
      <input name="title" type="text" class="create__input">
      <h2 class="title">Содержание статьи</h2>
      <textarea form="form" name="text" id="" class="create__textarea" placeholder="Впишите сюда ваш текст"></textarea>
      <select form="form" name="select" id="select" class="form__select" multiple>
          <#if categoriesList??>
              <#if categoriesList?has_content>
                  <#list categoriesList as category>
                    <option form="find" name="option" value="${category.id}" class="form__option">${category.name}</option>
                  </#list>
              </#if>
          </#if>
      </select>
      <input type="submit" class="create__submit" value="Создать">
    </div>
  </form>
</div>
</body>
</html>