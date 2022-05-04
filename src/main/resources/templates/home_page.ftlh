<!doctype html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="styles/header.css" type="text/css" />
  <link rel="stylesheet" href="styles/home.css" type="text/css" />
  <title>Hikipedia</title>
</head>
<body>
<div class="wrapper">
  <#include "_header.ftlh">
  <main class="page">
    <section class="page__main-top main-top">
      <div class="main-top__container container">
        <div class="main-top__content">
          <div class="main-top__left">
            <h2 class="main-top__title">Добро пожаловать</h2>
          </div>
          <div class="main-top__right">
            <a href="/create" class="main-top__create">Создать статью</a>
          </div>
        </div>
        <div class="main-top__find">
          <form>
            <div class="form__container">
              <select form="find" name="select" id="select" class="form__select" multiple>
                <option form="find" name="option" value="all" class="form__option">По всем категориям</option>
                <#if categoriesList??>
                  <#if categoriesList?has_content>
                    <#list categoriesList as category>
                      <option form="find" name="option" value="${category.id}" class="form__option">${category.name}</option>
                    </#list>
                  </#if>
                </#if>
              </select>
              <input name="search" form="find" type="text" class="form__input" placeholder="Поиск">
              <button form="find" class="form__button" id="form__button">Поиск</button>
            </div>
          </form>
        </div>
      </div>
    </section>
    <section class="page__main-block main-block">
      <div class="main-block__container container">
        <div class="main-block__content">
            <#if articlesList??>
                <#if articlesList?has_content>
                    <#list articlesList as article>
                      <div class="main-block__item">
                        <a href="/contribution/${article.id}" class="main-block__link">
                          <span>${article.title}</span>
                          <span class="main-block__author">Автор: ${article.author.name}</span>
                        </a>
                      </div>
                    </#list>
                    <#else>
                      <p class="main-block__paragraph">
                        Пока не создано ни одной статьи. Будьте первым!
                      </p>
                </#if>
            </#if>
        </div>
      </div>
    </section>
  </main>
</div>
</body>
</html>