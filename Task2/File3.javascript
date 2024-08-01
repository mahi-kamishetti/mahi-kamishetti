const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();
const port = 3000;

// Product prices
const productPrices = {
    1: 3.00,
    2: 1.50,
    3: 2.00
};

app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, 'public')));

app.post('/order', (req, res) => {
    const { productId } = req.body;
    if (productPrices.hasOwnProperty(productId)) {
        const total = productPrices[productId];
        res.json({ total });
    } else {
        res.status(400).json({ error: 'Invalid product ID' });
    }
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
