function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기

    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

  	//새로운 이미지 div 추가
    let existFile=document.getElementById('img');
   if(existFile==null){
    var newImage = document.createElement("img");
    newImage.setAttribute("id", 'img');
   

    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "15%";
    newImage.style.height = "15%";
    newImage.style.visibility = "visible";
    newImage.style.objectFit = "contain";

    //이미지를 image-show div에 추가
    var container = document.getElementById('image-show');
    container.appendChild(newImage);
   }else{
    existFile.setAttribute("src", URL.createObjectURL(file))
   }

};


// JavaScript to toggle the notification dropdown

const notificationButton = document.getElementById('notification-button');
const notificationDropdown = document.getElementById('notification-dropdown');
let isDropdownOpen = false;

notificationButton.addEventListener('click', () => {
    // Toggle the visibility of the notification dropdown
    isDropdownOpen = !isDropdownOpen;
    if (isDropdownOpen) {
        notificationDropdown.style.display = 'block';
    } else {
        notificationDropdown.style.display = 'none';
    }
});

// Close the dropdown when clicking outside of it
window.addEventListener('click', (event) => {
    if (!notificationButton.contains(event.target) && !notificationDropdown.contains(event.target)) {
        notificationDropdown.style.display = 'none';
        isDropdownOpen = false;
    }
});
