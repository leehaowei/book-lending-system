<template>
  <div>
    <h2>Register</h2>
    <form @submit.prevent="register">
      <div>
        <label for="phone_number">Phone Number:</label>
        <input type="text" id="phone_number" v-model="user.phone_number" />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" />
      </div>
      <div>
        <label for="user_name">User Name:</label>
        <input type="text" id="user_name" v-model="user.user_name" />
      </div>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

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
  methods: {
    async register() {
      try {
        const response = await axios.post('http://localhost:8080/api/app_users', this.user);
        console.log('User registered:', response.data);
      } catch (error) {
        console.error('Error registering user:', error);
      }
    },
  },
};
</script>
