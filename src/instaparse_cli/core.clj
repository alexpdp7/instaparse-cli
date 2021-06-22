(ns instaparse-cli.core
  (:require
   [instaparse.core :as insta],
   [clojure.data.json :as json])
  (:gen-class))

(defn parse-paths [grammar-path to-parse-path]
  (let [grammar (slurp grammar-path)
        to-parse (slurp to-parse-path)]
    (insta/add-line-and-column-info-to-metadata to-parse ((insta/parser grammar) to-parse))))

(defn add-meta-node [node]
  (cond
    (keyword? node) node
    (string? node) node
    :else (let [node-meta (meta node) [type & children] node] {:type type, :meta node-meta, :children (map add-meta-node children)})))

(defn add-meta-ast [ast] (map add-meta-node ast))

(defn -main
  [grammar-path to-parse-path]
  (println (json/write-str (add-meta-ast (parse-paths grammar-path to-parse-path)))))
