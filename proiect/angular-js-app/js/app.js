	var app = angular.module('blog', []);

	app.controller('HomeController', function($scope,$http) {				/* Persoana */
	  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
	  
	  var url = "http://localhost:8080/persoana.json";
	  $http.get(url).success(function(response){
		
		$scope.persoana = response;
		console.log($scope.persoana);
		
		$scope.persoane = [];
		$scope.fields = response;

		$scope.person = {};
		$scope.editPerson = {};
		});

		$http.get(url).then(function successCallback(response) {

			$scope.persoane = response.data;
			$scope.fields = Object.keys(response.data[0]);

			console.log($scope.persoana);
			//console.log($scope.fields);

		});
		
		$scope.addPersoana = function() {
			persoana.id = parseInt(persoana.id);
			console.log(persoana.id);
			$http({
				method: 'POST',
				url: url,
				data: persoana
			}).then(function successCallback(response) {
				console.log(response);
				$scope.persoane.push(persoana);
				// done.
			}, function errorCallback(response) {
				console.log(response);
			});
		};
		
		$scope.deletePersoana = function(id) {
			$http({
				method: 'DELETE',
				url: url+'/' + id,
				data: {}
			}).then(function successCallback(response) {
				// aici nu intra niciodata ca e functia de succes
			}, function errorCallback(response) {
				// aici intra pentru ca da eroare
				$scope.persoane = $scope.persoane.filter(function(obj) {
					return obj.id !== id;
				});
			});
		};

		$scope.setUpdatePerson = function(person) {
			$scope.editPerson = person;
		};

		$scope.updatePerson = function() {
			$http({
				method: 'PUT',
				url: url,
				data: $scope.editPerson
			}).then(function successCallback(response) {
				$scope.editPerson = {};
				console.log(response);
				$scope.persoane.push($scope.editPerson);
				// done.
			}, function errorCallback(response) {
				$scope.editPerson = {};
				console.log(response);
			});
		};
	   
	 });	
	 
	 
																		/* Angajat */
	app.controller('AngajatController', function($scope,$http) {
	  
	  var url = "http://localhost:8080/angajat.json";
	  $http.get(url).success(function(response){
		
		$scope.angajat = response;
		console.log($scope.angajat);
		
		$scope.angajati = [];
		$scope.fields = response;

		$scope.employee = {};
		$scope.editEmployee = {};
		});

		$http.get(url).then(function successCallback(response) {

			$scope.angajati = response.data;
			$scope.fields = Object.keys(response.data[0]);

			console.log($scope.angajat);
			console.log($scope.fields);

		});
		
		$scope.addAngajat = function(angajat) {
			angajat.id = parseInt(angajat.id);
			console.log(angajat.id);
			$http({
				method: 'POST',
				url: url,
				data: angajat
			}).then(function successCallback(response) {
				console.log(response);
				$scope.angajati.push(angajat);
				// done.
			}, function errorCallback(response) {
				console.log(response);
			});
		};
		
		$scope.deleteAngajat = function(id) {
			$http({
				method: 'DELETE',
				url: url+'/' + id,
				data: {}
			}).then(function successCallback(response) {
				// aici nu intra niciodata ca e functia de succes
			}, function errorCallback(response) {
				// aici intra pentru ca da eroare
				$scope.angajati = $scope.angajati.filter(function(obj) {
					return obj.id !== id;
				});
			});
		};

		$scope.setUpdateEmployee = function(employee) {
			$scope.editEmployee = employee;
		};

		$scope.updateEmployee = function() {
			$http({
				method: 'PUT',
				url: url,
				data: $scope.editEmployee
			}).then(function successCallback(response) {
				$scope.editEmployee = {};
				console.log(response);
				// $scope.angajati.push($scope.editEmployee);
				// done.
			}, function errorCallback(response) {
				$scope.editEmployee = {};
				console.log(response);
			});
		};
	   
	 });

																		/* Masina */
	app.controller('MasinaController', function($scope,$http) {
	  
	  var url = "http://localhost:8080/masina.json";
	  $http.get(url).success(function(response){
		
		$scope.masina = response;
		console.log($scope.masina);
		
		$scope.masini = [];
		$scope.fields = response;

		$scope.car = {};
		$scope.editCar = {};
		});

		$http.get(url).then(function successCallback(response) {

			$scope.masini = response.data;
			$scope.fields = Object.keys(response.data[0]);

			console.log($scope.masina);
			//console.log($scope.fields);

		});
		
		$scope.addMasina = function(masina) {
			masina.id = parseInt(masina.id);
			console.log(masina.id);
			$http({
				method: 'POST',
				url: url,
				data: masina
			}).then(function successCallback(response) {
				console.log(response);
				$scope.masini.push(masina);
				// done.
			}, function errorCallback(response) {
				console.log(response);
			});
		};
		
		$scope.deleteMasina = function(id) {
			$http({
				method: 'DELETE',
				url: url+'/' + id,
				data: {}
			}).then(function successCallback(response) {
				// aici nu intra niciodata ca e functia de succes
			}, function errorCallback(response) {
				// aici intra pentru ca da eroare
				$scope.masini = $scope.masini.filter(function(obj) {
					return obj.id !== id;
				});
			});
		};

		$scope.setUpdateCar = function(car) {
			$scope.editCar = car;
		};

		$scope.updateCar = function() {
			$http({
				method: 'PUT',
				url: url,
				data: $scope.editCar
			}).then(function successCallback(response) {
				$scope.editCar = {};
				console.log(response);
				// $scope.masini.push($scope.editCar);
				// done.
			}, function errorCallback(response) {
				$scope.editCar = {};
				console.log(response);
			});
		};
	   
	 });


	app.controller('TelefonController', function($scope,$http) {				/* Telefon */
	  
	  var url = "http://localhost:8080/telefon.json";
	  $http.get(url).success(function(response){
		
		$scope.telefon = response;
		console.log($scope.telefon);
		
		$scope.telefoane = [];
		$scope.fields = response;

		$scope.phone = {};
		$scope.editPhone = {};
		});

		$http.get(url).then(function successCallback(response) {

			$scope.telefoane = response.data;
			$scope.fields = Object.keys(response.data[0]);

			console.log($scope.telefon);
			console.log($scope.fields);

		});
		
		$scope.addTelefon = function(telefon) {
			telefon.id = parseInt(telefon.id);
			console.log(telefon.id);
			$http({
				method: 'POST',
				url: url,
				data: telefon
			}).then(function successCallback(response) {
				console.log(response);
				$scope.telefoane.push(telefon);
				// done.
			}, function errorCallback(response) {
				console.log(response);
			});
		};
		
		$scope.deleteTelefon = function(id) {
			$http({
				method: 'DELETE',
				url: url+'/' + id,
				data: {}
			}).then(function successCallback(response) {
				// aici nu intra niciodata ca e functia de succes
			}, function errorCallback(response) {
				// aici intra pentru ca da eroare
				$scope.telefoane = $scope.telefoane.filter(function(obj) {
					return obj.id !== id;
				});
			});
		};

		$scope.setUpdatePhone = function(phone) {
			$scope.editPhone = phone;
		};

		$scope.updatePhone = function() {
			$http({
				method: 'PUT',
				url: url,
				data: $scope.editPhone
			}).then(function successCallback(response) {
				$scope.editPhone = {};
				console.log(response);
				// $scope.telefoane.push($scope.editPhone);
				// done.
			}, function errorCallback(response) {
				$scope.editPhone = {};
				console.log(response);
			});
		};
	   
	 });		 