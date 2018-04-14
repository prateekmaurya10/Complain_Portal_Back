app.controller("ComplaintList", function ($scope, $localStorage) {
   $scope.complaintAsList = $localStorage.newComplaintLocal;
  // $scope.id = $localStorage.newComplaintLocal.id;
   $scope.summary = $localStorage.newComplaintLocal.summary;
   $scope.complaintType = $localStorage.newComplaintLocal.complaintId;
   $scope.user = $localStorage.CurrentUserName;
});