const http = require('http'); 
const fs = require('fs');
const { parse } = require('querystring');

const server = http.createServer((req, res) => {
    if (req.method === 'GET') {
        fs.readFile('index.html', (err, content) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('Error loading the form');
            } else {
                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.end(content);
            }
        });
    } else if (req.method === 'POST' && req.url === '/register') {
        req.on('data', (body) => {
            const parsedData = parse(body.toString());
            if (parsedData.password !== parsedData.confirmpassword) {
                res.writeHead(400, { 'Content-Type': 'text/plain' });
                res.end('Error: Password and Confirm Password do not match.');
                return;
            }
            let users = [];
            try {
                const existingData = fs.readFileSync('users.json', 'utf8');
                users = JSON.parse(existingData);
            } catch (err) {}
            const existingUser = users.find(user => user.mobile === parsedData.mobile);
            if (existingUser) {
                res.writeHead(400, { 'Content-Type': 'text/plain' });
                res.end('You are already registered with this mobile number.');
                return;
            }
            const { confirmpassword, ...userWithoutConfirmPassword } = parsedData;
            users.push(userWithoutConfirmPassword);
            fs.writeFile('users.json', JSON.stringify(users, null, 2), (err) => {
                if (err) {
                    res.writeHead(500, { 'Content-Type': 'text/plain' });
                    res.end('Error saving data');
                } else {
                    res.writeHead(200, { 'Content-Type': 'text/plain' });
                    res.end('Registration successful!');
                }
            });
        });
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

server.listen(3000, () => {
    console.log('Server running at http://localhost:3000');
});
