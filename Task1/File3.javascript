const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const port = 3000;

// In-memory vote counts
const votes = {
    'Option 1': 0,
    'Option 2': 0,
    'Option 3': 0
};

app.use(cors());
app.use(bodyParser.json());
app.use(express.static('public'));  // Serve static files from the 'public' directory

app.post('/vote', (req, res) => {
    const { option } = req.body;
    if (votes.hasOwnProperty(option)) {
        votes[option]++;
        res.json(votes);
    } else {
        res.status(400).json({ error: 'Invalid option' });
    }
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
