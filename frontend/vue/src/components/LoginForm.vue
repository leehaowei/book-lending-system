<template>
  <div class="container">
    <h2>Login</h2>
    <form @submit.prevent="login" class="form">
      <div class="input-group">
        <label for="username">Phone Number:</label>
        <input type="text" id="username" v-model="user.username" />
      </div>
      <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" />
      </div>
      <button type="submit" class="submit-btn">Login</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import { useRouter } from 'vue-router';
import BooksList from './BookList.vue';
import {getAllBooks} from "../auth/auth.js"; // Import the BooksList component

export default {
  components: {
    BooksList,
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
      books: [], // Add a new data property to store the books
    };
  },
  setup() {
    const router = useRouter();
    return { router };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('http://localhost:8080/api/auth/login', this.user);
        console.log('User logged in:', response.data);
        if (response.status === 200) {
          localStorage.setItem('jwtToken', response.data.token);
          const fetchedBooks = await getAllBooks(); // Get the books from the getAllBooks function
          this.books = fetchedBooks; // Assign the fetched books to the component's data
          this.router.push('/books');
        }
      } catch (error) {
        console.error('Error logging in user:', error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
  padding: 1rem;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
}

.form {
  display: flex;
  flex-direction: column;
}

.input-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}

label {
  margin-bottom: 0.5rem;
}

input {
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.submit-btn {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit-btn:hover {
  background-color: #0056b3;
}
</style>
