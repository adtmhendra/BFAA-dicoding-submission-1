package com.hendra.dicodingsubmission

import android.content.res.TypedArray
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val users = ArrayList<User>()
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataBackgroundImage: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.supportActionBar?.title = "Github User"
        // Optimation RecyclerView length & width
        rvUsers.setHasFixedSize(true)
        // getting data from getUserData()
        users.addAll(getAllUserData())
        // making ListView as a default View
        showRecyclerList()
    }

    private fun getAllUserData() : ArrayList<User> {
        dataUsername   = resources.getStringArray(R.array.username)
        dataName       = resources.getStringArray(R.array.name)
        dataLocation   = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany    = resources.getStringArray(R.array.company)
        dataFollowers  = resources.getStringArray(R.array.followers)
        dataFollowing  = resources.getStringArray(R.array.following)
        dataAvatar     = resources.obtainTypedArray(R.array.avatar)
        dataBackgroundImage = resources.obtainTypedArray(R.array.background)

        val user = ArrayList<User>()
        for (i in dataName.indices) {
            val listUser = User (
                dataUsername[i],
                dataName[i],
                dataLocation[i],
                dataRepository[i],
                dataCompany[i],
                dataFollowers[i],
                dataFollowing[i],
                dataAvatar.getResourceId(i, -1),
                dataBackgroundImage.getResourceId(i, -1)
            )
            user.add(listUser)
        }
        return user
    }

    private fun showRecyclerList() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(users)
        rvUsers.adapter = listUserAdapter
    }

    private fun showGridUser() {
        rvUsers.layoutManager = GridLayoutManager(this, 2)
        val gridUserAdapter = GridUserAdapter(users)
        rvUsers.adapter = gridUserAdapter
    }

    private fun showCardViewUser() {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val cardVieweUserAdapter = CardViewUserAdapter(users)
        rvUsers.adapter = cardVieweUserAdapter
    }

    // from this line until the end of code are setting mode menu for (list/grid/card) view
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMenu(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMenu(selectedMenu: Int) {
        when (selectedMenu) {
            R.id.listUser -> showRecyclerList()
            R.id.gridUser -> showGridUser()
            R.id.cardViewUser -> showCardViewUser()
        }
    }
}