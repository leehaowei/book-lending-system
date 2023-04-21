<template>
  <div>
    <h2>Registration Successful</h2>
    <p>You have successfully registered. Please log in to continue.</p>
    <button @click="goToLogin">Login</button>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  setup() {
    const router = useRouter();
    const goToLogin = () => {
      router.push('/login');
    };
    return { goToLogin };
  },
};
</script>
