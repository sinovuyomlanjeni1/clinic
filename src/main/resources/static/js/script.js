document.addEventListener("DOMContentLoaded", function () {

    const deleteButtons = document.querySelectorAll("a.btn-danger");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function (e) {
            const message = button.textContent.trim().toLowerCase();

            if (message.includes("delete") || message.includes("cancel")) {
                if (!confirm("Are you sure you want to proceed?")) {
                    e.preventDefault();
                }
            }
        });
    });

});

