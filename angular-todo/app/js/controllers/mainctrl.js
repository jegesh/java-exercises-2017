angular.module("SampleApp").controller("MainController", ['$scope', function($scope) {
  $scope.tasks = [{
          description: "default task",
          date: new Date(),
          worker: 'robot'
  }];
  $scope.newTask = {
      date: new Date()
  };
  $scope.showAddForm = false;
  
  $scope.toggleAddForm = function toggleAddForm(){
    $scope.showAddForm = !$scope.showAddForm;  
  };
  
  $scope.sendForm = function sendForm(){
    if($scope.newTask.description.length > 20){
        alert("Description is too long");
        return;
    }
    $scope.tasks.push($scope.newTask);
    $scope.newTask = {date: new Date()};
    $scope.showAddForm = false;
  };
  
  $scope.deleteTask = function deleteTask(task){
    for(var i in $scope.tasks){
       var currentTask = $scope.tasks[i];
          if(task == currentTask){
              $scope.tasks.splice(i, 1);
//            delete $scope.tasks[i]; // deletes the object but not the place in the array
              debugger;
          } 
    }
  };
  
}]);