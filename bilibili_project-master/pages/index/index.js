Page({

  /**
   * 页面的初始数据
   */
  data: {

    //被点击的首页导航栏的菜单的索引
    currentIndexNav:0,
    //首页导航数据
    navList: ["首页","动画","番剧","国创","音乐","舞蹈","科技","游戏","娱乐","鬼畜","电影","电视剧","纪录片","影视","时尚","生活","广告","直播","相簿"],
    //轮播图数据
    swiperList: [],
    //视频列表数据
    videoList: [
      {num:0,
       video_img:"../../Video_img/img1.jpg",
       comments:"里博士后的电视剧三十万村民围观",
       play_num:"5.5w",
       comment_num:"1.2k"
      },
      {num:1,
       video_img:"../../Video_img/img2.jpg",
       comments:"2020年风尚大赏于广州拉开帷幕",
       play_num:"7564",
       comment_num:"42"
      },
      {num:2,
       video_img:"../../Video_img/img3.jpg",
       comments:"震惊！憨厚小伙竟在幕后玩口红...",
       play_num:"3205",
       comment_num:"75"
      },
      {num:3,
       video_img:"../../Video_img/img4.jpg",
       comments:"今年会是最后一届总选么",
       play_num:"3.2w",
       comment_num:"378"
      },
      {num:4,
       video_img:"../../Video_img/img5.jpg",
       comments:"平均身高170+？人高马大社会队名不虚传",
       play_num:"1.8w",
       comment_num:"95"
      },
      {num:5,
       video_img:"../../Video_img/img6.jpg",
       comments:"无意间两双对峙的眼睛",
       play_num:"520",
       comment_num:"520"
      },
      {num:6,
       video_img:"../../Video_img/img7.jpg",
       comments:"为何沉默让彼此更坚定",
       play_num:"1314",
       comment_num:"1314"
      },
      {num:7,
       video_img:"../../Video_img/img8.jpg",
       comments:"那些百看不厌的金曲舞台",
       play_num:"10.5w",
       comment_num:"2k6"
      },
      {num:8,
       video_img:"../../Video_img/img9.jpg",
       comments:"2020.2.29陈王可返图",
       play_num:"1748",
       comment_num:"9"
      },
      {num:9,
       video_img:"../../Video_img/img10.jpg",
       comments:"顽皮儿子翻出老夫妻的年轻时照片 美颜惊呆众人",
       play_num:"4632",
       comment_num:"87"
      }
    ]
  },

  //点击首页导航按钮
  activeNav(e){
    // console.log(e)
    this.setData({
      currentIndexNav:e.target.dataset.index
    })
  },
/**
   * 获取轮播图数据
   */
  getSwiperList(){
    let that=this;
    wx.request({
      url:"http://mock-api.com/mnEe4VnJ.mock/swiperList",
      success(res){
        // console.log(res);
        if(res.data.code===0){
          that.setData({
            swiperList:res.data.data.swiperList
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  // 2 调用获取轮播图数据的函数
  this.getSwiperList();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})