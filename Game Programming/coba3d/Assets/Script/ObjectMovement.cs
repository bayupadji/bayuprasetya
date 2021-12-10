using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObjectMovement : MonoBehaviour
{
    // Start is called before the first frame update
    Vector3 kanan;
    Vector3 kiri;
    Vector3 atas;
    Vector3 bawah;

    // public int aksi;
    float speed = 3 ;
    int score;

    static Quaternion toQuaternion (Vector3 euler) 
    {
        Quaternion q;
        float pitch = euler.y;
        float roll = euler.x;
        float yaw = euler.z;
        float t0 = Mathf.Cos(yaw * 0.5f);
        float t1 = Mathf.Sin(yaw * 0.5f);
        float t2 = Mathf.Cos(roll * 0.5f);
        float t3 = Mathf.Sin(roll* 0.5f);
        float t4 = Mathf.Cos(pitch * 0.5f);
        float t5 = Mathf.Sin(pitch * 0.5f);
        Debug.Log (t0 + " " + t1 + " " + t2 + " " + t3 + " " + t4 + " " + t5 + " ");

        q.x = t0 * t3 * t4 - t1 * t2 * t5;
        q.y = t0 * t2 * t5 + t1 * t3 * t4;
        q.z = t1 * t2 * t4 - t0 * t3 * t5;
        q.w = t0 * t2 * t4 + t1 * t3 * t5;
        return q;
    }

    void Start()
    {
        kanan = new Vector3(1, 0, 0);
        kiri = new Vector3(-1, 0, 0);
        atas = new Vector3(0, 1, 0);
        bawah = new Vector3(0, -1, 0);
    }

    // Update is called once per frame
    void Update()
    {
       if (Input.GetKey("right"))
            transform.position = transform.position +(kanan * speed * Time.deltaTime);
       if (Input.GetKey("left"))
            transform.position = transform.position +(kiri * speed * Time.deltaTime);
       if (Input.GetKey("up"))
            transform.position = transform.position +(atas * speed * Time.deltaTime);
       if (Input.GetKey("down"))
            transform.position = transform.position +(bawah * speed * Time.deltaTime);
    }

    void OnCollisionEnter2D(Collision2D coll){
        if (coll.gameObject.tag == "enemyTag"){
            Debug.Log("Game Over");
            Time.timeScale = 0;
            Destroy(gameObject);
        }

        if (coll.gameObject.tag == "coinTag"){
            score++; 
            Debug.Log("skor : "+ score);
        }
    }

    // void OnCollisionStay2D(Collision2D coll){
    //     if (coll.gameObject.tag == "enemyTag"){
    //         Debug.Log("Sedang Nabrak");
    //     }
    // }

    // void OnCollisionExit2D(Collision2D coll){
    //     if (coll.gameObject.tag == "enemyTag"){
    //         Debug.Log("Sudah Nabrak");
    //     }
    // }


}
