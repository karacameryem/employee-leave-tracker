$(document).ready(function() {
    // Çalışan Ekle
    $('#addEmployeeForm').submit(function(event) {
        event.preventDefault();
        const employee = {
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            email: $('#email').val(),
            department: $('#department').val()
        };
        $.ajax({
            url: '/employees',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(employee),
            success: function(response) {
                alert('Çalışan başarıyla eklendi!');
                $('#addEmployeeForm')[0].reset();
            },
            error: function() {
                alert('Bir hata oluştu!');
            }
        });
    });

    // İzin Güncelle
    $('#leaveForm').submit(function(event) {
        event.preventDefault();
        const employeeId = $('#employeeId').val();
        const days = $('#days').val();
        $.ajax({
            url: `/employees/leave?employeeId=${employeeId}&days=${days}`,
            type: 'POST',
            success: function(response) {
                alert(response);
                $('#leaveForm')[0].reset();
            },
            error: function() {
                alert('Bir hata oluştu!');
            }
        });
    });
});

function getEmployees() {
    $.ajax({
        url: '/employees',
        type: 'GET',
        success: function(employees) {
            const list = $('#employeeList');
            list.empty();
            employees.forEach(emp => {
                list.append(`<li>${emp.id} - ${emp.firstName} ${emp.lastName}, Departman: ${emp.department}, Kalan İzin: ${emp.leaveDays}</li>`);
            });
        },
        error: function() {
            alert('Çalışanlar getirilemedi!');
        }
    });
}
