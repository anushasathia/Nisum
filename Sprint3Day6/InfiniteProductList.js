import React, { useEffect, useRef, useState, useCallback } from 'react';
import allProducts from './products.json'; 
import './InfiniteProductList.css'; 

const PAGE_SIZE = 6; 

const categories = ["All", "Tops", "Bottoms", "Dresses", "Outerwear", "Footwear", "Accessories"];

const InfiniteProductList = () => {
  const [visibleProducts, setVisibleProducts] = useState([]);
  const [page, setPage] = useState(1);
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [isLoading, setIsLoading] = useState(false);
  const [hasMore, setHasMore] = useState(true); 
  const loader = useRef(null); 

  
  const filteredProducts = React.useMemo(() => {
    return selectedCategory === "All"
      ? allProducts
      : allProducts.filter(p => p.category === selectedCategory);
  }, [selectedCategory]);


  useEffect(() => {
    setIsLoading(true);
    setPage(1); 
    const initialProducts = filteredProducts.slice(0, PAGE_SIZE);
    setVisibleProducts(initialProducts);
    setHasMore(initialProducts.length < filteredProducts.length);
    setIsLoading(false);
  }, [selectedCategory, filteredProducts]); 

  const loadMore = useCallback(() => {
    if (isLoading || !hasMore) return; 
    setIsLoading(true);
    const nextPage = page + 1;
    const startIndex = (nextPage - 1) * PAGE_SIZE;
    const endIndex = startIndex + PAGE_SIZE;
    const newProductsBatch = filteredProducts.slice(startIndex, endIndex);

    if (newProductsBatch.length > 0) {
      setVisibleProducts(prevProducts => [...prevProducts, ...newProductsBatch]);
      setPage(nextPage);
      setHasMore(visibleProducts.length + newProductsBatch.length < filteredProducts.length);
    } else {
      setHasMore(false);
    }
    setIsLoading(false);
  }, [page, isLoading, hasMore, filteredProducts, visibleProducts.length]);

  useEffect(() => {
    const observer = new IntersectionObserver(
      (entries) => {
        const target = entries[0];
        if (target.isIntersecting && !isLoading && hasMore) {
          loadMore();
        }
      },
      {
        root: null, 
        rootMargin: '200px',
        threshold: 0.1,
      }
    );

    if (loader.current) {
      observer.observe(loader.current);
    }

    return () => {
      if (loader.current) {
        observer.unobserve(loader.current);
      }
    };
  }, [loadMore, isLoading, hasMore]); 

  return (
    <div style={{ padding: "20px", maxWidth: "1200px", margin: "0 auto", fontFamily: "Arial, sans-serif" }}>
      <h2 style={{ textAlign: "center", marginBottom: "30px", color: "#333" }}>Infinite Product List</h2>

      <div className="tabs">
        {categories.map(cat => (
          <button
            key={cat}
            onClick={() => setSelectedCategory(cat)}
            className={selectedCategory === cat ? "active" : ""}
          >
            {cat}
          </button>
        ))}
      </div>

      <div className="product-grid">
        {visibleProducts.map(product => (
          <div className="product-card" key={product.id}>
            <strong>{product.name}</strong>
            <p>${product.price.toFixed(2)}</p>
            <p>Category: {product.category}</p>
          </div>
        ))}
      </div>

      {isLoading && (
        <div className="loader">
          <p>Loading more products...</p>
        </div>
      )}

      {!hasMore && !isLoading && visibleProducts.length > 0 && (
        <div className="loader">
          <p>You've reached the end of the list.</p>
        </div>
      )}

      {hasMore && <div ref={loader} style={{ height: '1px' }} />}
    </div>
  );
};

export default InfiniteProductList;