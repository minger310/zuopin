// pages/details/details.js
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		// 视频详情
		videoInfo:[],
		// 其他一些视频地址：
		// http://uksir.gitee.io/bilibili/medias/2018120195458.mp4
		// http://uksir.gitee.io/bilibili/medias/20181219211856.mp4
		// http://uksir.gitee.io/bilibili/medias/20181219211920.mp4
		// http://uksir.gitee.io/bilibili/medias/20181219211910.mp4
		url:"http://wxsnsdy.tc.qq.com/105/20210/snsdyvideodownload?filekey=30280201010421301f0201690402534804102ca905ce620b1241b726bc41dcff44e00204012882540400&bizid=1023&hy=SH&fileparam=302c020101042530230204136ffd93020457e3c4ff02024ef202031e8d7f02030f42400204045a320a0201000400",
		// 推荐视频信息
		recommend_info:[{
			img_url:"../../Video_img/img1.jpg",
			title:"村里博士后的电视剧三十万村民围观",
			play_num:"15.5w",
			comment_num:"1.2"
		},{
			img_url:"../../Video_img/img2.jpg",
			title:"2020年风尚大赏于广州拉开帷幕",
			play_num:"7564",
			comment_num:"72"
		},{
			img_url:"../../Video_img/img3.jpg",
			title:"震惊！憨厚小伙竟在幕后玩口红...",
			play_num:"3505",
			comment_num:"75"
		},{
			img_url:"../../Video_img/img4.jpg",
			title:"今年会是最后一届总选么",
			play_num:"3.2w",
			comment_num:"378"
		},{
			img_url:"../../Video_img/img5.jpg",
			title:"平均身高170+？人高马大社会队名不虚传",
			play_num:"1.8w",
			comment_num:"95"
		},{
			img_url:"../../Video_img/img6.jpg",
			title:"无意间两双对峙的眼睛",
			play_num:"520",
			comment_num:"520"
		},{
			img_url:"../../Video_img/img7.jpg",
			title:"为何沉默让彼此更坚定",
			play_num:"1314",
			comment_num:"1314"
		},{
			img_url:"../../Video_img/img8.jpg",
			title:"那些百看不厌的金曲舞台",
			play_num:"10.5w",
			comment_num:"2k6"
		},{
			img_url:"../../Video_img/img9.jpg",
			title:"2020.2.29陈王可返图",
			play_num:"1748",
			comment_num:"9"
		},{
			img_url:"../../Video_img/img10.jpg",
			title:"顽皮儿子翻出老夫妻的年轻时照片 美颜惊呆众人",
			play_num:"4632",
			comment_num:"87"
		}],
		// 评论数据
		commentData:null
	},
	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function (options) {
		// 从主页传递过来的视频id参数
		// console.log(options);
		let videoId=options.id;
		this.getvideoInfo(videoId);
		this.getCommentList(videoId);
	},
	getvideoInfo(videoId){
		let that=this;
		var videoId = parseInt(videoId);
		videoId=videoId+1;
		that.setData({
			videoInfo:{videotitle:"第"+videoId+"个视频",
						author:"第"+videoId+"个",
						play_count:videoId+250,
						comment_count:videoId+500,
						time:"12-"+videoId}
		})
	},
	// 获取评论数据
	getCommentList(videoId){
		let that=this;
		wx.request({
			url:"https://easy-mock.com/mock/5c1dfd98e8bfa547414a5278/bili/commentsList?id="+videoId,
			success(res){
				//console.log(res);
				if(res.data.code===0){
					that.setData({
						commentData:res.data.data.commentData
					})
				}
			}
		})
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