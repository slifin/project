(ns electric-starter-app.main
  (:require [hyperfiddle.electric3 :as e]
            [hyperfiddle.electric-dom3 :as dom]
            #?(:cljs [electric-starter-app.project])))

(e/defn Main [ring-request]
  (e/client
    (binding [dom/node js/document.body]
      (dom/link (dom/props {:rel :stylesheet, :href "/tutorial.css"})))))
