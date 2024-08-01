const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// Sample courses data
const courses = {
    1: { title: 'JavaScript Basics', description: 'Learn the basics of JavaScript.', instructor: 'John Doe' },
    2: { title: 'Advanced JavaScript', description: 'Dive deeper into JavaScript.', instructor: 'Jane Smith' },
    3: { title: 'Introduction to Node.js', description: 'Get started with Node.js.', instructor: 'Mary Johnson' }
};

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));

app.post('/enroll', (req, res) => {
    const { courseId } = req.body;
    if (courses[courseId]) {
        res.json(courses[courseId]);
    } else {
        res.status(400).json({ error: 'Invalid course ID' });
    }
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
