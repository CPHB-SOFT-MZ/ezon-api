
$(document).ready(function () {

    /**
     * Add Building
     */
    $('#sign-up-form').validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 12
            },
            repeatPassword: {
              required: true,
              equalTo: "password"  
            }
        },
        highlight: function (element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function (element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block'
    });

});