export async function login(username, password) {
    try {
        const response = await fetch('http://localhost:8080/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username: username,
                password: password,
            }),
        });

        if (response.ok) {
            const authResponse = await response.json();
            const jwtToken = authResponse.token;
            localStorage.setItem('jwtToken', jwtToken); // Save the token in local storage
            return true;
        } else {
            console.error('Error during login:', response.status, response.statusText);
            return false;
        }
    } catch (error) {
        console.error('Error during login:', error);
        return false;
    }
}

export async function getAllBooks() {
    const jwtToken = localStorage.getItem('jwtToken');

    if (!jwtToken) {
        console.error('No JWT token found');
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/api/books', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${jwtToken}`,
                'Content-Type': 'application/json',
            },
        });

        if (response.ok) {
            const books = await response.json();
            return books; // Return the fetched books
        } else {
            console.error('Error fetching books:', response.status, response.statusText);
        }
    } catch (error) {
        console.error('Error fetching books:', error);
    }
}
