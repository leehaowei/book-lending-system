<template>
  <div class="book-list">
    <h1>Books</h1>
    <ul>
      <li v-for="book in books" :key="book.id" class="book-item">
        <span class="book-name">{{ book.name }}</span> by <span class="book-author">{{ book.author }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
import { getAllBooks } from "../auth/auth.js";

export default {
  data() {
    return {
      books: [],
    };
  },
  async created() {
    this.books = await getAllBooks();
  },
};
</script>

<style scoped>
.book-list {
  font-family: Arial, sans-serif;
  max-width: 600px;
  margin: 0 auto;
  padding: 2rem;
  background-color: #f9f9f9;
  border-radius: 5px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 1.5rem;
}

.book-item {
  margin: 0.5rem 0;
  padding: 0.5rem;
  background-color: #fff;
  border-radius: 3px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.book-name {
  font-weight: bold;
}

.book-author {
  color: #666;
}
</style>

