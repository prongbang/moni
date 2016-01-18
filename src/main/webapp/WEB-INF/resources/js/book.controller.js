// @Controller
moni.controller("bookController", function ($scope, $http) {

    var me = this;

    $scope.id = null;
    $scope.name = null;
    $scope.price = null;
    $scope.books = [];

    $scope.init = function () {
        $('#books').DataTable();
        me.id = $("#id")[0];
        me.name = $("#name")[0];
        me.price = $("#price")[0];
    };
    $scope.init();

    // Event Click
    $scope.add = function () {

        if ($(me.id).val() != "" && $(me.name).val() != "" && $(me.price).val() != "") {

            var data = {
                id: parseInt($(me.id).val()),
                name: $(me.name).val(),
                price: parseFloat($(me.price).val())
            };

            $http.post(BASEURL + "/book/add", data).success(function (response) {
                if (response.result == 1) {
                    $scope.reset();
                    $scope.reload();
                }
            });
        }

    };

    $scope.reset = function () {
        $(me.id).val("");
        $(me.name).val("");
        $(me.price).val("");
    };

    $scope.reload = function () {
        window.location.reload();
    };

});
