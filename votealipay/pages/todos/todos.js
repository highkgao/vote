const app = getApp();

Page({
  data: {},
  onLoad() {
    if (userInfo == null) {
      
    }
   
  },
  onShow() {
    this.setData({ todos: app.todos });
  },
  onTodoChanged(e) {
    const checkedTodos = e.detail.value;
    app.todos = app.todos.map(todo => ({
      ...todo,
      completed: checkedTodos.indexOf(todo.text) > -1,
    }));
    this.setData({ todos: app.todos });
  },
  addTodo() {
    my.navigateTo({ url: '../add-todo/add-todo' });
  },
});
