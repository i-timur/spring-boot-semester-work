const select = $('#select');
const input = $('#input');
const container = $('.main-block__content');

const getArticle = ({id, title, author}) => {
  return `<div class="main-block__item"><a href="/article?id=${id}" class="main-block__link"><span>${title}</span> <span class="main-block__author">Автор: ${author}</span></a></div>`
}

const getUrlWithParams = (url, map) => {
  let params = '';
  for (let key of Object.keys(map)) {
    if (map[key]) {
      params += `${key}=${map[key]}&`
    }
  }
  return `${url}?${params}`;
};

const debounce = (func, timeout = 300) => {
  let timer;
  return (...args) => {
    clearTimeout(timer);
    timer = setTimeout(() => {
      func.apply(this, ...args)
    }, timeout);
  };
};

const onSuccess = (articles) => {
  container.html('');
  if (articles.length) {
    for (let article of articles) {
      container.append(getArticle(article));
    }
  } else {
    container.html('<p class="main-block__paragraph">Пока не создано ни одной статьи. Будьте первым!</p>')
  }
};

$.ajax({
  url: '/articles',
  method: 'GET',
  success: onSuccess
});

select.change(() => {
  const params = {
    categoryId: select.val() === 'all' ? null : select.val(),
    searchTerm: input.val().trim() ? input.val() : null
  }

  $.ajax({
    url: getUrlWithParams('/articles', params),
    method: 'GET',
    success: onSuccess
  });
});

input.on('keyup', debounce(() => {
  const params = {
    categoryId: select.val() === 'all' ? null : select.val(),
    searchTerm: input.val().trim() ? input.val() : null
  }

  $.ajax({
    url: getUrlWithParams('/articles', params),
    method: 'GET',
    success: onSuccess
  });
}));