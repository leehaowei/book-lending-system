<template>
  <div class="container">
    <h2>Register</h2>
    <form @submit.prevent="register" class="form">
      <div class="input-group">
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" v-model="user.phone_number" />
      </div>
      <div class="input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" />
      </div>
      <div class="input-group">
        <label for="user_name">User Name:</label>
        <input type="text" id="user_name" v-model="user.user_name" />
      </div>
      <button type="submit" class="submit-btn">Register</button>
      <router-link to="/login" class="secondary-btn">Login</router-link>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import { useRouter } from 'vue-router';

export default {
  data() {
    return {
      user: {
        phone_number: '',
        password: '',
        user_name: '',
      },
    };
  },
  setup() {
    const router = useRouter();
    return { router };
  },
  methods: {
    async register() {
      try {
        const response = await axios.post('http://localhost:8080/api/users', this.user);
        console.log('User registered:', response.data);
        if (response.status === 200) {
          this.router.push('/registration-success');
        }
      } catch (error) {
        console.error('Error registering user:', error);
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

.secondary-btn {
  display: inline-block;
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  color: #fff;
  background-color: #6c757d;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-decoration: none;
  margin-left: 0rem;
}

.secondary-btn:hover {
  background-color: #5a6268;
}
</style>

