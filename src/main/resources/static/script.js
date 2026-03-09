function SaveStudent(){

	let id = document.getElementById("studentId").value;

	let student={
		name:document.getElementById("name").value,
		address:document.getElementById("StudentAddress").value,
		studentClass:document.getElementById("studentClass").value
	};

	// UPDATE
	if(id){
		fetch(`http://localhost:8080/students/${id}`,{
			method:"PUT",
			headers:{
				"Content-Type":"application/json"
			},
			body:JSON.stringify(student)
		})
		.then(response=>response.text())
		.then(data=>{
			alert("Student Updated Successfully");
			getStudent();
		});
	}

	// INSERT
	else{
		fetch("http://localhost:8080/students",{
			method:"POST",
			headers:{
				"Content-Type":"application/json"
			},
			body:JSON.stringify(student)
		})
		.then(response=>response.json())
		.then(data=>{
			alert("Student Saved Successfully");
			getStudent();
		});
	}
}


function getStudent(){

fetch("http://localhost:8080/students")
.then(response=>response.json())
.then(data=>{
let tableBody=document.getElementById("studentTableBody");
tableBody.innerHTML="";

data.forEach(student=>{
let row=document.createElement("tr");
row.innerHTML = `
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.address}</td>
<td>${student.studentClass}</td>
<td>
<button class="deleteBtn" onclick="deleteStudent(${student.id})">Delete</button>
<button class="updateBtn" onclick="editStudent(${student.id},'${student.name}','${student.address}','${student.studentClass}')">Edit</button>
</td>
`;


tableBody.appendChild(row);

});

});
}


function deleteStudent(id){
	
	fetch(`http://localhost:8080/students/${id}`,{
		method:"DELETE"
	})
	.then(response=>response.text())
	.then(data=>{
		alert(data);
		getStudent();
		
	});
	
}

function editStudent(id,name,address,studentClass){
	document.getElementById("studentId").value=id;
	document.getElementById("name").value=name;
	document.getElementById("StudentAddress").value=address;
	document.getElementById("studentClass").value=studentClass;
}



