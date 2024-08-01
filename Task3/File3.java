// scripts.js

document.addEventListener('DOMContentLoaded', () => {
    const courses = [
        { id: 1, title: "Introduction to JavaScript", description: "Learn the basics of JavaScript.", image: "course1.jpg" },
        { id: 2, title: "Advanced CSS Techniques", description: "Master advanced CSS techniques.", image: "course2.jpg" },
        { id: 3, title: "HTML5 and CSS3", description: "Build responsive web pages with HTML5 and CSS3.", image: "course3.jpg" },
        { id: 4, title: "React for Beginners", description: "Get started with React.js.", image: "course4.jpg" }
    ];

    // Populate featured courses on the homepage
    const coursesContainer = document.getElementById('courses-container');
    courses.forEach(course => {
        const courseElement = document.createElement('div');
        courseElement.className = 'course';
        courseElement.innerHTML = `
            <img src="${course.image}" alt="${course.title}">
            <h3>${course.title}</h3>
            <p>${course.description}</p>
            <a href="course-detail.html?id=${course.id}" class="button">Learn More</a>
        `;
        coursesContainer.appendChild(courseElement);
    });

    // Filter courses in the catalog
    const searchInput = document.getElementById('search');
    const courseList = document.getElementById('course-list');

    function updateCourseList(query) {
        courseList.innerHTML = '';
        const filteredCourses = courses.filter(course => course.title.toLowerCase().includes(query.toLowerCase()));
        filteredCourses.forEach(course => {
            const courseElement = document.createElement('div');
            courseElement.className = 'course';
            courseElement.innerHTML = `
                <img src="${course.image}" alt="${course.title}">
                <h3>${course.title}</h3>
                <p>${course.description}</p>
                <a href="course-detail.html?id=${course.id}" class="button">View Details</a>
            `;
            courseList.appendChild(courseElement);
        });
    }

    if (searchInput) {
        searchInput.addEventListener('input', (event) => {
            updateCourseList(event.target.value);
        });
    }

    // Load course detail on course-detail.html
    const courseDetail = document.getElementById('course-detail');
    const urlParams = new URLSearchParams(window.location.search);
    const courseId = parseInt(urlParams.get('id'));

    if (courseId && courseDetail) {
        const course = courses.find(c => c.id === courseId);
        if (course) {
            courseDetail.innerHTML = `
                <h2>${course.title}</h2>
                <img src
