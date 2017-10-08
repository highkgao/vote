App({
  
  todos: [
    { text: 'Learning Javascript', completed: true },
    { text: 'Learning ES2016', completed: true },
    { text: 'Learning 支付宝小程序', completed: false },
  ],
  userInfo: null,
  voteUser: null,
  getUserInfo() {
    return new Promise((resolve, reject) => {
      if (this.userInfo) resolve(this.userInfo);

      my.getAuthCode({
        scopes:'auth_user',
        success: (authReturn) => {

          my.httpRequest({
            url: 'http://www.lovetoupiao.com/voteweb/user/alipayUserAuthorize.json', // 目标服务器 url
            data: {
              "authCode" : authReturn.authCode
            },
            success: (res) => {
              this.voteUser = res;
            },
            fail: (res) => {
              my.alert({
                title: '远程获取信息失败', // alert 框的标题
                content: res
              });
            },  
          });

          my.getAuthUserInfo({
            scopes: ['auth_user'],
            success: (res) => {
              this.userInfo = res;
              resolve(this.userInfo);
            },
            fail: () => {
              reject({});
            },
          });
        },
        fail: (res) => {
          my.alert({
            title: '授权失败', // alert 框的标题
            content: res.authErrorScope
          });
        },
      });
    });
  },
});
