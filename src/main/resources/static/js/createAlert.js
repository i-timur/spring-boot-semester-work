$(document).ready(() => {
  const noAccess = window.location.href.split('?')[1];
  if (noAccess) {
    alert('У вас нет прав, чтобы создавать пост');
  }
});