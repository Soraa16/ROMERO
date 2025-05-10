function toggleSidebar() {
  const sidebar = document.getElementById("sidebar");
  const openBtn = document.getElementById("openBtn");

  if (sidebar.style.width === "250px") {
    sidebar.style.width = "0";
    openBtn.style.display = "block";
  } else {
    sidebar.style.width = "250px";
    openBtn.style.display = "none"; 
  }
}