(ns electric-starter-app.project
  (:require ["babylonjs" :as BABYLON]))

(defn create-scene [engine canvas]
  (let [scene (BABYLON/Scene. engine)
        camera (BABYLON/FreeCamera. "camera1" (BABYLON/Vector3. 0 5 -10) scene)
        light (BABYLON/HemisphericLight. "light1" (BABYLON/Vector3. 0 1 0) scene)
        sphere (.CreateSphere BABYLON/Mesh "sphere1" 16 2 scene false (.-FRONTSIDE BABYLON/Mesh))
        ground (.CreateGround BABYLON/Mesh "ground1" 6 6 2 scene false)]

    ;; Configure the camera
    (.setTarget camera (BABYLON/Vector3.Zero))
    (.attachControl camera canvas false)

    ;; Move the sphere upward by half of its height
    (set! (.-position.y sphere) 1)

    ;; Return the created scene
    scene))

(defn init []
  (let [canvas (.getElementById js/document "game")
        engine (BABYLON/Engine. canvas true #js {:preserveDrawingBuffer true :stencil true})
        scene (create-scene engine canvas)]

    ;; Run the render loop
    (.runRenderLoop engine #(.render scene))

    ;; Handle window resize events
    (.addEventListener js/window "resize" #(engine.resize))))

;; Call init to start the application
(init)
