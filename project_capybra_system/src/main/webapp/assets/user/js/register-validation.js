document.querySelector("#register-form").addEventListener("submit", function (e) {
    let isValid = true;

    document.querySelectorAll(".text-danger").forEach(el => el.textContent = "");

    let fullname = document.getElementById("fullName");
    if(fullname.value.trim() === ""){
        document.getElementById("error-fullName").textContent = "Họ tên không được để trống";
        isValid = false;
    }

    const username = document.getElementById("username");
    if (username.value.trim().length < 4) {
        document.getElementById("error-username").textContent = "Tên tài khoản phải có ít nhất 4 ký tự.";
        isValid = false;
    }

    // Validate mật khẩu
    const password = document.getElementById("password");
    if (password.value.length < 6) {
        document.getElementById("error-password").textContent = "Mật khẩu phải có ít nhất 6 ký tự.";
        isValid = false;
    }

    // Validate số điện thoại
    const phone = document.getElementById("phone");
    const phoneRegex = /^[0-9]{10,11}$/;
    if (!phoneRegex.test(phone.value)) {
        document.getElementById("error-phone").textContent = "Số điện thoại không hợp lệ.";
        isValid = false;
    }

    // Validate email
    const email = document.getElementById("email");
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.value)) {
        document.getElementById("error-email").textContent = "Email không hợp lệ.";
        isValid = false;
    }

    // Validate địa chỉ
    const address = document.getElementById("address");
    if (address.value.trim() === "") {
        document.getElementById("error-address").textContent = "Địa chỉ không được để trống.";
        isValid = false;
    }

    const account = document.getElementById("error");
    if(account.value == "account-existed"){
        document.getElementById("error-username").textContent = "Tài khoản đã tồn tại.";
        isValid = false;
    }

    if (!isValid) {
        e.preventDefault(); // Ngăn form submit nếu có lỗi
    }
});
