//获取新闻分类


function getdata(){
    $.ajax({
        url:'../public/findall',
        method:'GET',
        async:false,
        success:(res)=>{
            $.cookie('news_category', res.object, { expires: 7 }); //设置为7天，默认值：浏览器关闭
        },
        error:()=>{
            alert("数据请求失败")
        }

    })
}