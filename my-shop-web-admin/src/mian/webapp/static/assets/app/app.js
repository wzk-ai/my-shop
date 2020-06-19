var App=function () {

    //私有属性
    var _masterCheckbox;
    var _checkbox;

    /**
     *初始化 iCheck
     */
    var handlerCheckbox=function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })

         //获取控制端checkbox
         _masterCheckbox=$("input[type='checkbox'].minimal.icheck_master")

         //获取全部checkbox集合
         _checkbox=$("input[type='checkbox'].minimal")
    };

    //全选功能
    var handlerCheckboxAll=function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //返回true表示未选中
            if (e.target.checked){
                _checkbox.iCheck("uncheck");
            }
            //选中状态
            else {
                _checkbox.iCheck("check");
            }
        })
    }
    
    
    /**
     * 暴露
     */
    return {
        init:function(){
            handlerCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
})