import { createRouter, createWebHashHistory } from 'vue-router';
import RegistrationForm from './components/RegistrationForm.vue';
import LoginForm from './components/LoginForm.vue';
import RegistrationSuccess from './components/RegistrationSuccess.vue';
import LoginSuccess from './components/LoginSuccess.vue';

const routes = [
    { path: '/', component: RegistrationForm },
    { path: '/login', component: LoginForm },
    { path: '/registration-success', component: RegistrationSuccess },
    { path: '/login-success', component: LoginSuccess },
];


const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;
