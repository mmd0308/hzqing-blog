<template>
    <div id="detailsFoot">
        <div class="support-author">
                <p>喜欢就告诉我~</p> 
                <div class="btn-pay">赞赏支持</div> 
                <div class="supporter">
                    <ul class="support-list">
                        <li>
                            <a target="_blank" href="/u/de2100caeda2" class="avatar">
                                <img src="//upload.jianshu.io/users/upload_avatars/8584695/8970ec75-a5e0-4420-b414-7b6fe925c806?imageMogr2/auto-orient/strip|imageView2/1/w/120/h/120">
                            </a>
                        </li>
                    </ul> <!---->
                </div> <!----> <!---->
        </div>
        <div class="meta-bottom">
            <div class="like">
                <div class="like-group">
                    <div class="btn-like">
                        <a href="/sign_in?utm_source=desktop&amp;utm_medium=not-signed-in-like-button">
                        <i class="iconfont ic-like"></i>喜欢</a>
                    </div> 
                    <div class="modal-wrap"><a>93</a></div>
                </div> <!---->
            </div>
            <div class="share-group">
                <a class="share-circle" >
                    分享
                </a>
            </div>
        </div>
    </div>
</template>
<style>
.support-author{
    padding: 30px 0 20px;
    text-align: center;
    clear: both;
    border-bottom: 1px solid #f0f0f0;
}
.support-author p{
    padding: 0 30px;
    margin-bottom: 20px;
    min-height: 24px;
    font-size: 17px;
}

.support-author .btn-pay {
    margin-bottom: 20px;
    padding: 8px 25px;
    font-size: 16px;
    color: #fff;
    background-color: #ec6149;
    border-radius: 20px;
    display: inline-block;
}
.supporter{
    height: 50px;
}
.supporter ul{
    list-style: none;
    display: inline-block;
    margin-top: 0;
    margin-bottom: 10px;
    padding-left: 0px;
}
.avatar{
    display: block;
    cursor: pointer;
    height: 40px;
    width: 40px;
}
.avatar img{
    width: 100%;
    height: 100%;
    border-radius: 50%;
    border: 3px solid #fff;
}
.meta-bottom{
    margin-top: 30px;
    margin-bottom: 80px;
}
.meta-bottom .like{
    display: inline-block;
}
.like-group{
    padding: 13px 0 10px;
    font-size: 0;
    border: 1px solid #ea6f5a;
    border-radius: 40px;
}
.btn-like{
    font-size: 19px;
    display: inline-block;    
}
.btn-like a{
    color: #ea6f5a;
    padding: 18px 15px 18px 30px;
    margin-right: 5px;
    font-size: 21px;
}
.btn-like a i{
    margin-right: 5px;
    font-size: 21px;
}
.modal-wrap{
    font-size: 18px;
    border-left: 1px solid rgba(236,97,73,.4);
    display: inline-block;
}
.modal-wrap a{
    color: #ea6f5a;
    padding: 18px 30px 18px 17px;
}
.share-group{
    float: right;
    margin-top: 6px;    
}
.share-circle{
    width: 50px;
    height: 50px;
    margin-left: 5px;
    text-align: center;
    border: 1px solid #dcdcdc;
    border-radius: 50%;
    vertical-align: middle;
    display: inline-block;
}
</style>

